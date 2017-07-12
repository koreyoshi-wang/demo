/**
 * This file include common JavaScript function for project
 */

/**
 *This function is used for parse ObjectId into String;
 *
 * <p>ObjectId consists of 12 bytes, divided as follows:</p>
 * <table border="1">
 *     <caption>ObjectID layout</caption>
 *     <tr>
 *         <td>0</td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td>
 *     </tr>
 *     <tr>
 *         <td colspan="4">time</td><td colspan="3">machine</td> <td colspan="2">pid</td><td colspan="3">inc</td>
 *     </tr>
 * </table>
 *
 */
function parseObjectId(objectId){
	var timestamp = objectId.timestamp;
	var machineIdentifier = objectId.machineIdentifier;
	var processIdentifier = objectId.processIdentifier;
	var counter = objectId.counter;
	return toFixedLengthHex(timestamp,8) + toFixedLengthHex(machineIdentifier,6) + toFixedLengthHex(processIdentifier,4) + toFixedLengthHex(counter,6);
}

function toFixedLengthHex(data, length) {
	var temp = data.toString(16);
	var temLegth = temp.length;
	if (length - temLegth > 0) {
		var gap = length - temLegth;
		for (var i = 0; i<gap; i++){
			temp = "0" + temp;
		}
	}
	return temp;
}


Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //æä»½ 
        "d+": this.getDate(), //æ¥ 
        "h+": this.getHours(), //å°æ¶ 
        "m+": this.getMinutes(), //å 
        "s+": this.getSeconds(), //ç§ 
        "q+": Math.floor((this.getMonth() + 3) / 3), //å­£åº¦ 
        "S": this.getMilliseconds() //æ¯«ç§ 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

/**
 * 截取字字符串为固定长度，超过固定长度显示省略号
 * @param source
 * @param len
 * @returns
 */
function stringCut(source, len){
	if(source){
		if(source.length<=len){
			return source;
		}else{
			return source.substring(0,len-1)+"...";
		}
	}else{
		return '';
	}
}