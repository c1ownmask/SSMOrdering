//新增标签页
function addTab(title, url) {
    var tabPanel = top.$('#_1_tabs');
    if (tabPanel.tabs('exists', title)) {
        tabPanel.tabs('select', title);
    } else {
        if (url == undefined || url == null || url == '') {
            return;
        }
        var content = '<div class="_maskDiv" style="position:absolute;width:100%;height:100%;top:30px;left:0px;background:#fff;z-index:1;"></div><iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;position:relative;"></iframe>';
        tabPanel.tabs('add', {
            title: title,
            content: content,
            closable: true
        });
    }
    $('._maskDiv').remove();
}