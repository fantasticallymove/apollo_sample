# apollo 極簡易的apollo配置中心範例

僅幾個步驟完成配置中心服務:

1.下載https://github.com/nobodyiam/apollo-build-scripts

2.下載MySql並且啟動MySqlServer

3.創建兩個專用的database給apollo使用 ApolloPortalDB 和 ApolloPortalDB 操作方式就是使用MySqlWorbence 的 create Schema 然後將官方提供的腳本複製然後運行即可 記得Schema 名稱要與
ApolloPortalDB ApolloPortalDB 一致。

以下為官方的兩個sql 連結

https://github.com/nobodyiam/apollo-build-scripts/blob/master/sql/apolloportaldb.sql

https://github.com/nobodyiam/apollo-build-scripts/blob/master/sql/apolloconfigdb.sql

![image](https://user-images.githubusercontent.com/60643078/180631565-6ea04d7b-e3a9-4a7e-8749-ff6576ab31dc.png)
![image](https://user-images.githubusercontent.com/60643078/180631587-692e978a-1cd5-436c-9aba-3acbc09a860c.png)
![image](https://user-images.githubusercontent.com/60643078/180631648-c9a80592-0a97-45fc-a6c3-a073fae43254.png)



4.確保8070, 8080, 8090 這三個端口無使用

5.在下載下來的apollo資料夾下 去修改demo.sh 這個檔案

![image](https://user-images.githubusercontent.com/60643078/180631513-0079dead-3677-4656-9c03-b03a94820c05.png)

5.使用Gitbash軟體 (它是一個linux 的git 專用工具) cd 到apollo 那個下載下來的資料夾 輸入 ./demo.sh start   (一定要使用GitBash 因為demo.sh有特殊對它支援不然會啟動不太順利)

![image](https://user-images.githubusercontent.com/60643078/180631697-f9e3b476-c544-41ae-8894-02c2a5916016.png)


6.可以嘗試訪問 http://localhost:8070 输入用户名apollo，密码admin后登录


7.將本專案的code下載下來就可以測試使用apollo 在服務中心上更改配置 和觀看springboot apolllo sample專案上面的log變化, 到這邊就大功告成了！



假如以上再啟動server 有報錯無法啟動請apollo-service.conf 檔案這邊加入 USE_START_STOP_DAEMON=false 如下圖

![image](https://user-images.githubusercontent.com/60643078/180631911-7265d808-e28a-4b91-b795-1d49f713a795.png)
