---
title: Design patterns --- Singleton
date: 2020-05-20 10:42:30
tags:
 - 设计模式
---

单例模式是最常用的设计模式之一，同时也是面试中最容易考到的设计模式。<!-- more -->

下面介绍几种典型的单例模式实现。

1. 懒汉单例模式
懒汉是指在第一次使用（调用getInstance()）时才会创建单例对象。
```java
// Lazy man Singleton
public class LazyManSingleton {
    private LazyManSingleton lazyManSingleton;

    private LazyManSingleton() {}

    public LazyManSingleton getInstance() {
        if (lazyManSingleton == null){
            lazyManSingleton = new LazyManSingleton();
        }
        return lazyManSingleton;
    }
}
```
2. 饿汉单例模式
与懒汉不同，饿汉是在类中就已经创建好了这个类的单例对象，使用时全是调用该对象。
```java
// Hungry man Singleton
public class HungryManSingleton {
    private HungryManSingleton lazyManSingleton = new HungryManSingleton();

    private HungryManSingleton() {}

    public HungryManSingleton getInstance() {
        return hungryManSingleton;
    }
}
```

# 单例模式实例应用 --- Eureka源码项目
`DiscoveryManager.java`
DiscoveryManager 的作用是通过读取配置文件来配置 Discovery Client。这里 DiscoveryManager 作为管理员，只需要一个对象就可以了，所以源码中使用了饿汉式单例模式来实现：
```java
/**
 * <tt>Discovery Manager</tt> configures <tt>Discovery Client</tt> based on the
 * properties specified.
 *
 * <p>
 * The configuration file is searched for in the classpath with the name
 * specified by the property <em>eureka.client.props</em> and with the suffix
 * <em>.properties</em>. If the property is not specified,
 * <em>eureka-client.properties</em> is assumed as the default.
 *
 * @author Karthik Ranganathan
 *
 */
public class DiscoveryManager {
    private static final DiscoveryManager s_instance = new DiscoveryManager();

    private DiscoveryManager() {
    }

    public static DiscoveryManager getInstance() {
        return s_instance;
    }
    
    ......
    
}
```

# 单例模式典型应用 --- 操作数据库

以 LevelDB 为例，每次新建一个数据库操作对象的时候都会在磁盘中新建一个数据库。如果只操作一个数据库，那么程序中只能存在一个全局对象，这就可以利用单例模式的方法来编写程序。

## 例：JavaContract项目

### 1. 类的定义
类的定义没有什么特殊的地方。
*src/contracts/contracts_db_wrapper.h*

### 2. 对象的声明

是通过全局对象来声明的。

*src/chainparams/state.h*
```cpp
typedef struct mc_State
{
    mc_State()
    {
        InitDefaults();
    }
    ~ mc_State()
    {
        Destroy();
    }
    ...
    ContractsDB             *m_Contracts;
    void InitDefaults()
    {
        ...
        m_Contracts = NULL;
    }
    void Destroy()
    {
        ...
        if (m_Contracts)
        {
            delete m_Contracts;
        }
    }
}
```


*src/contracts/contracts_db_wrapper.cpp*
```
void ContractsItem::Zero()
{
    ...
    contracts_DB = new mc_Database;
    mc_GetFullFileName(name, "contracts", ".db", MC_FOM_RELATIVE_TO_DATADIR|MC_FOM_CREATE_DIR, m_FileName);
}
```
由此可以看出，单例模式是一种思想，具体实现不拘泥与教科书上的几种形式。

### 3. 对象的使用
在系统初始化的时候新建这个对象
*src/core/init-cold.cpp*
```
if(mc_gState->m_Contracts->Initialize(mc_gState->m_Params->NetworkName()))
{
    seed_error=strprintf("ERROR: Couldn't initialize contract database for blockchain %s. Please restart multichaind with reindex=1.\n",mc_gState->m_Params->NetworkName());
    return InitError(_(seed_error.c_str()));
}

```

# 单例模式经典应用 --- 配置文件读取
