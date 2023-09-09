###  基于velocity及自定义模板实现一个易上手且自定义程度高的代码生成器


 **自定义代码生成器三步曲** 
1. 定义模板
2. 添加参数
3. 将参数模板和生成类相互关联

### 首先第一步模板，模板首先得选个语法简单、直观的，所以选择 velocity 
只需要了解  **占位符** 、 **判断** 、 **循环**  即可

<img width="668" alt="image" src="https://github.com/loserYa/easy-gen-code/assets/144508529/fd89ddd1-05de-468c-8f07-cc2af747152f">



### 第二步添加参数 这边为了能有自己把控上下文的内容，提供多种参数传递规则
（包括全局上下文、当前文件上下文）

1. 直接从配置获取 **json** 写入全局（前三个三选一）
2. 从配置中获取实现了  **PutContextHandler**  接口的处理类的结果写入全局（前三个三选一）
3. 从默认提供的 **jdbc** 处理类中写入全局（前三个三选一）
4. 从配置中获取实现了  **FilePutContextHandler**  接口的处理按照文件id写入当前文件的上下文（可不设置）
5. 从方法入口中添加实现了  **PostCurFiledContextAware**  接口的处理类写入当前文件的上下文（可不设置）
6. 从配置的  **params**  中直接写入全局（可不设置）
7. 从  **FunctionUtils**  中注册自定义函数（可不设置）

### 第三步关联模板

<img width="723" alt="image" src="https://github.com/loserYa/easy-gen-code/assets/144508529/79efa4ae-b523-48ae-a712-27c6c78b5e6a">



