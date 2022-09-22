
$("#stadiumlist").click(() => {
});

$("#btnConfirm").click(() => {
	createPlayer();
});


function deletePlayer(id){
	$.ajax("/Player/delete/"+id,{
		type:"DELETE",
		dataType:"json",
	}).done((res)=>{
		if(res.code == 1){
			alert(res.msg);
			location.href="/player";
		}else{
			alert("삭제실패");
			return;
		}
	});
}


function createPlayer() {
	let team = {
		name: $("#name").val(),
		teamId: $("#teamlist").val(),
		position: $("#position").val()

	}
	if(checkValidation(team, 1)){
		return;
	}
	

	$.ajax("/player/create", {
		type: "POST",
		dataType: "json",
		data: JSON.stringify(team),
		headers: {
			"Content-Type": "application/json; charset=utf8"
		}
	}).done((res) => {
		if (res.code == 1) {
			alert("플레이어가 등록되었습니다.");
			location.href = "/player";
		} else {
			alert(res.msg);
			$("#name").val("");
			return;
		}
	});
}

function checkValidation(data, checkoption) {
	let pattern = /\s/g;
	let upper = /[A-Z]/;
	let korRule = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	if (checkoption == 1) {
		if (pattern.test(data.name)) {
			alert("공백발생");
			return true;
		}
	}
	return false;
}