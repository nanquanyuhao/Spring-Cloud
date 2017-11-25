# 使用 java 自带的 keytool 工具生成一对密钥，密码 123456
keytool.exe -genkeypair -alias "testKey" -keyalg "RSA" -keystore "D:\myTest.keystore"