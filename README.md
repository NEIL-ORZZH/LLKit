# LLKit
Personal Dev Kits
---

### LLLog

- 日志工具类
- 默认TAG＝LLLog,提供方法修改
- 可设置Log是否打印
- 五种级别的Log

### LLSON

- JSON工具类
- 提供一个JSON字符串＋一个JavaBean的Class即可自动绑定JSON的值到Bean
- JavaBean的属性名需与JSON中的一致
- 目前支持Int、String、String[]三种类型的基本类型,其他未测试,基本同理
- 支持嵌套子类

### LLHttp

- Http工具类
- 向指定URL获取InputStream值,再由`LLStearm`将InputStream转换为String
- 默认为GET方式请求数据,未提供方法修改
- 需要设置超时时间

### LLPackageInfo

- Apk包信息工具类
- 获取Apk包的相关信息
- 目前只有获取版本名,其他的同理,有需要再添加

### LLStearm

- Stearm工具类
- 将InputStream转换为String
