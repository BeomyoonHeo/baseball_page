
$("#stadiumlist").click(() => {
});

$("#btnConfirm").click(() => {
	createPlayer();
});

$("#btnDelete").click(() => {
	DeletePlayerList();
})

$("#teamgroup").change(()=>{
	if($("#teamgroup").val()==null){
		groupForTeam(null);
	}
	groupForTeam($("#teamgroup").val());
})

function groupForTeam(id){
	
	$.ajax("/player/groupteam/"+id,{
		
		type:"GET",
		dataType:"json"
	}).done((res)=>{
		if(res.code == 1){
			console.log(res.data)
			$("#table tr").remove();
			res.data.forEach((o, i)=>{
				
				$("#table").append('<tr><td>'+o.row+'</td>'+
				'<td>'+o.name+'</td>'+
				'<td>'+o.position+'</td>'+
				'<td>'+o.name+'</td>'+
				'<td>'+o.createDate+'</td>'+
				'<td><a href="/player/update/'+o.id+'">수정</a></td>'+
				'<td><input class="form-check-input" type="checkbox" name="checkbox" value="'+o.id+'"></td></tr>');
			});
		}
	});
	
}


function DeletePlayerList() {

	let chkArray = new Array();

	$("input[name='checkbox']:checked").each(function() {
		let item = $(this).val();
		chkArray.push(item);
	});

	if (chkArray.length < 1) {
		alert("값을 선택해주시기 바랍니다.");
		return;
	}

	deletePlayer(chkArray);

}


function deletePlayer(id) {


	$.ajax("/Player/delete/", {
		type: "DELETE",
		dataType: "json",
		data: { deletelist: id },
		Headers: {
			"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
		}
	}).done((res) => {
		if (res.code == 1) {
			alert("삭제 완료");
			location.href = "/player";
		}
	});
}


function createPlayer() {
	let team = {
		name: $("#name").val(),
		teamId: $("#teamlist").val(),
		position: $("#position").val()

	}
	if (checkValidation(team, 1)) {
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