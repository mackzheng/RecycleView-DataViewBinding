# RecycleView-DataViewBinding
进度：目前在整理框架代码。

主要功能：实现RecycleView数据绑定的UI框架。
主要目的：与ReactNative 和 Weex跨端的方案不同，这里主要解决Android原生APP列表的相关问题。

解决问题：
1.列表单元复用问题。
2.减少adpater处理视图逻辑
3.降低列表的维护成本。
4.所有列表，如果存在视图对应的数据，都能展示提前绑定的视图单元。
5.一份数据源可以对应多份视图的。
6.所有列表视图，统一管理。
7.解决动态运营的问题。

后续工作：
列表单元视图支持热更新，视图单元可以下发代码。
列表单元功能支持的细化。（视图能够跳转内部activity，跳转webview，跳转内部相机，相册，跳转其他APP）

框架结构：
1.
2.
3.
4.

接入说明：
1.
2.
3.
4.
