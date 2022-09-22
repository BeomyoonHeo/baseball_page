$("#btnConfirm").click(()=>{
	creatStadium();
});

function creatStadium(){
	let stadium = {
		name:$("#name").val()
	}
	if(checkValidation(stadium, 1)){
		return;
	}
	
	$.ajax("/stadium/create", {
		type: "POST",
		dataType: "json",
		data:JSON.stringify(stadium),
		headers:{
			"Content-Type":"application/json; charset=utf8"
		}
	}).done((res)=>{
		if(res.code == 1){
			alert("경기장이 생성되었습니다.");
			location.href="/";
		}else{
			alert(res.msg);
			$("#name").val("");
			return;
		}
	});
}
function checkValidation(data, checkoption){
	let pattern = /\s/g;
	let upper = /[A-Z]/;
	let korRule = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	if(checkoption == 1){
	if(pattern.test(data.name)){
		alert("공백발생");
		return true;
	}
	}
	return false;
}