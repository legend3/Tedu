# 组合优于继承
>从普通的具体类跨越包级边界继承，是危险的.(提醒一下，本书使
用“继承”一词来表示实现继承（当一个类继承另一个类时）。 在这个项目中讨论的问题不适用于接口继承（当类实现
接口或当接口继承另一个接口时）)。
## 与方法调用不同，继承打破了封装
>一个子类依赖于其父类的实现细节来保证其正确的功
能。 父类的实现可能会从发布版本不断变化，如果是这样，子类可能会被破坏，即使它的代码没有任何改变。 因
此，一个子类必须与其超类一起更新而变化，除非父类的作者为了继承的目的而专门设计它，并对应有文档的说明。

## 核心：在转发类中创建现有类的引用，让现有类(父类)自己调用自己的方法，达到不影响现有类的后续扩充，而转发类类(子类)不受影响。

https://www.cnblogs.com/JaxYoun/p/14982768.html