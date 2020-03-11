### spi: service provider interface
1. 由使用接口的一方提供接口
2. 其他第三方实现接口
3. 接口使用方可以自由选择使用哪一种实现

> from [知乎](https://zhuanlan.zhihu.com/p/28909673)
> 1. 概念上更依赖调用方
> 2. 组织上位于调用方所在的包中
> 3. 实现位于独立的包中（也可认为在提供方中）


### 操作
- 定义spi的接口(见 `usage.Search`)
- 使用 ServiceLoader 类对spi接口的实现进行选择和加载(见 `usage.SpiTest`)
- 在项目类路径(`src`)下添加 `MATE-INF/service` 目录
- 在 `MATE-INF/service` 目录下创建以spi接口全类名命名的文件(`xx.xx.usage.Search`， 暂且称为 **spi文件**)
- 在 **spi文件** 中添加具体实现类的全类名(`xx.xx.provider.FileSearcher`)
- 打包项目为一个 jar 包，运行