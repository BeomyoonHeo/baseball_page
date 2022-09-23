$("#btnConfirm").click(()=>{
	creatStadium();
});

$("#btnDelete").click(() => {
	DeletestadiumList();
})

function DeletestadiumList() {

	let chkArray = new Array();

	$("input[name='checkbox']:checked").each(function() {
		let item = $(this).val();
		chkArray.push(item);
	});

	if (chkArray.length < 1) {
		alert("값을 선택해주시기 바랍니다.");
		return;
	}
	deleteStadium(chkArray);

}

function deleteStadium(id) {
	
	
	$.ajax("/stadium/delete", {
		type: "DELETE",
		dataType: "json",
		data:{deletelist:id},
		Headers:{
			"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8"
		}
	}).done((res)=>{
		if(res.code == 1){
			alert(res.msg);
			location.href="/stadium";
		}
	});
}

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