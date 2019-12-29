/* POJ 3507 */
#include <stdio.h>
#include <algorithm>

int main()
{
#ifndef ONLINE_JUDGE
freopen("input.txt","r",stdin);
#endif // ONLINE_JUDGE
  int In[6];
  while(scanf("%d%d%d%d%d%d",In,In+1,In+2,In+3,In+4,In+5)!=EOF)
  {
    int i = 99;
    char buffer[100] = {'0'};
    // 全部为0则停止输入
    if(!In[0]&&!In[1]&&!In[2]&&!In[3]&&!In[4]&&!In[5])break;
    std::sort(In,In+6);
    sprintf(buffer,"%.2f",(In[1]+In[2]+In[3]+In[4])/(float)4);
    // 定位到末尾的0
    while (buffer[i]=='\0')
      -- i;
    // 去掉小数点末尾的0
    while (buffer[i] == '0')
      buffer[i--] = '\0';
    // 去掉小数点
    if (buffer[i] == '.')
      buffer[i] = '\0';
    printf("%s\n", buffer);
  }
  return 0;
}