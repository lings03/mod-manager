# Mod实验室

# 写在前面

**本软件与官方无任何关系，如果侵犯到你的权益请联系我删除**

**使用本软件造成的一切后果与开发者无关，请低调使用软件，不要跳脸官方**

**后续会开放源代码，本人水平有限，代码写的稀烂，仅为实现功能，如果你有更好的实现方式或者有Bug反馈，请提交issues**

**本软件不提供任何Mod文件，请自行寻找**

## 已实现功能

**注意本软件功能高度依赖shizuku（为兼容安卓14）**

1. [X] 扫描QQ下载目录中的Mod
2. [X] 扫描系统Download目录中的Mod
3. [X] 一键开启反和谐
4. [X] 支持加密Mod
5. [X] 支持Mod预览
6. [X] 支持在Mod中添加作者信息（详见[MOD打包](#MOD打包)）
7. [X] 支持任意的Mod打包方式，例如多级目录，不在局限于单一形式（详见Mod打包部分）
8. [X] 支持一个压缩文件中打包多个不同Mod（详见Mod打包部分）
9. [X] **Mod目前仅支持Zip格式压缩**

## 软件使用说明

**[点击下载](https://github.com/laoxinH/crosscore-mod-manager/releases)最新的Mod实验室**

**运行界面（实验室需要shizuku授权，如果不知道怎么使用shizuku请参考[shizuku官方使用说明](https://shizuku.rikka.app/zh-hans/guide/setup/#%E9%80%9A%E8%BF%87%E6%97%A0%E7%BA%BF%E8%B0%83%E8%AF%95%E5%90%AF%E5%8A%A8)）**

![1715962256872](image\readme\1715962256872.png?msec=1715965017839 "app主页")![1715962345763](image\readme\1715962345763.png?msec=1715965017839 "首次打开Mod页面")![1715962369620](\image\readme\1715962369620.png?msec=1715965017829)

![1715962378369](\image\readme\1715962378369.png?msec=1715965017831 "shizuku授权")![1715962396435](\image\readme\1715962396435.png?msec=1715965017839 "扫描到的mod")![1715962416212](\image\readme\1715962416212.png?msec=1715965017839 "设置页面")

- **首次运行打开Mod页面会请仔细阅读后点击*同意并授权*才能继续使用软件**
- **授权后需要重新打开Mod页面将会扫描Mod**
- **默认扫描控制台*配置的Mod目录*，需要扫描QQ目录和系统下载目录请去控制台开启**
- **扫描的的Mod会自动移动到配置的Mod目录，方便管理**
- **新曾Mod建议直接放置到配置的Mod目录**
- ~~在设置页面可以点击给作者买杯卡布奇洛支持一下~~

## MOD打包

**注意打包MOD目前仅支持ZIP格式**

**主意打包MOD目前仅支持ZIP格式**

**主意打包MOD目前仅支持ZIP格式**

- [x] **MOD压缩文件推荐结构**

![1715963940732](\image\readme\1715963940732.png?msec=1715965017840)

- **如果不存在readme文件，MOD实验室会提示：未适配MOD管理器，可能存在未知问题**

**readme.txt文件内容示例**

![1715964083599](\image\readme\1715964083599.png?msec=1715965017836)

名称：刃齿爱心眼小玩具
描述：替换默认和动画
作者：laoxin
版本：1.0

**注意冒号为中文标点**

- [x] 支持一个压缩包打包多份MOD

![1715964191813](\image\readme\1715964191813.png?msec=1715965017839)

- **MOD实验室判断不同MOD的标准之一就是以文件夹区分**
- **在实验中显示的MOD名称将会是压缩文件名（文件夹名称），如果存在readme.txt文件将会显示其中的名称**
- **压缩在同一份压缩文件中的MOD都可以存在一份readme文件用于描述，例如在testmod1和testmod2都可以存在readme文件**
- **支持多级目录，但是不推荐**
- **一个推荐的方案是将mod文件（必须存在），预览图（可有可无，推荐添加）、readme（可有可无，推荐添加）三类文件放置到同一个文件夹中**
- **支持加密压缩文件，注意加密后将无法预览MOD详细信息，谨慎使用**
