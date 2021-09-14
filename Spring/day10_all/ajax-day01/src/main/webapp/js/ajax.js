//获得ajax对象
function getXhr(){
	var xhr = null;
	if(window.XMLHttpRequest){
		//非ie浏览器
		xhr = new XMLHttpRequest();
	}else{
		//ie浏览器
		xhr = new ActiveXObject(
				"MicroSoft.XMLHttp");
	}
	return xhr;
}

//依据id返回相应的节点。
function $(id){
	return document.getElementById(id);
}

//返回指定节点的value值。
function $F(id){
	return $(id).value;
}














