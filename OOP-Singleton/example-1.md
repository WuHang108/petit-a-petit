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