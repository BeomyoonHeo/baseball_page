$("#btnConfirm").click(() => {
	createTeam();
});

$("#btnDelete").click(() => {
	DeleteTeamList();
})

function DeleteTeamList() {

	let chkArray = new Array();

	$("input[name='checkbox']:checked").each(function() {
		let item = $(this).val();
		chkArray.push(item);
	});

	if (chkArray.length < 1) {
		alert("값을 선택해주시기 바랍니다.");
		return;
	}
	deleteTeam(chkArray);

}

function deleteTeam(id) {
	
	
	$.ajax("/team/delete", {
		type: "DELETE",
		dataType: "json",
		data:{deletelist:id},
		Headers:{
			"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8"
		}
	}).done((res)=>{
		if(res.code == 1){
			alert(res.msg);
			location.href="/team";
		}
	});
}



function createTeam() {
	let team = {
		name: $("#name").val(),
		stadiumId: $("#stadiumlist").val(),

	}

	$.ajax("/team/create", {
		type: "POST",
		dataType: "json",
		data: JSON.stringify(team),
		headers: {
			"Content-Type": "application/json; charset=utf8"
		}
	}).done((res) => {
		if (res.code == 1) {
			alert("팀이 생성되었습니다.");
			location.href = "/team";
		} else {
			alert(res.msg);
			$("#name").val("");
			return;
		}
	});
}