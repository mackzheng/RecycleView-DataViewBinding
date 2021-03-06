# RecycleView-DataViewBinding
扩展阅读：jetpack框架数据绑定框架：liveData  DataBinding

###主要功能

实现RecycleView数据绑定的UI框架。
与ReactNative 和 Weex跨端的方案不同，这里主要解决Android原生APP列表的相关问题。

###进度：
- 第一期：整理框架;实现一个基本使用demo。
- 第二期：完善框架;接入更多使用示例。
- 第三期：框架支持动态下发ViewHolder。
- 第四期：整理说明文档。

###解决问题：

1.列表单元复用问题。
2.减少adpater处理视图逻辑
3.降低列表的维护成本。
4.所有列表，如果存在视图对应的数据，都能展示提前绑定的视图单元。
5.一份数据源可以对应多份视图的。
6.所有列表视图，统一管理。
7.解决动态运营的问题。

###后续工作：

列表单元视图支持热更新，视图单元可以下发代码。
列表单元功能支持的细化。（视图能够跳转内部activity，跳转webview，跳转内部相机，相册，跳转其他APP）


###关键类和代码：
```
BaseRecyclerViewAdapter //数据绑定的Adapter封装
BaseViewHolderFactory   //数据绑定工作基类封装

DataViewBindFactory //数据绑定工厂（userInfo 与 viewHolder的映射）
UserInfoListActivity //用户信息列表实现 
```

在UserInfoListActivity中，如下代码将工厂类注入到RecyclerAdapter中。
为列表关联数据绑定关系
```
@Override
protected BaseRecyclerViewAdapter onCreateListAdapter() {
    DataViewBindFactory factory = new DataViewBindFactory(this);
    mAdapter = new BaseRecyclerViewAdapter(factory); //可以扩展BaseRecyclerViewAdapter
    factory.bindDateToView(mAdapter);
    return mAdapter;
}

```
 
