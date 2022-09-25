let expulsionlist = new Array();

$("#btnConfirm").click(() => {
	createExpulsion();
})

function teamfilter(data) {

	$.ajax("/expulsion/team/" + data, {
		type: "GET",
		dataType: "json",
	}).done((res) => {
		if(res.code == 1){
			$("#table tr").remove();
			res.data.forEach((o, i)=>{
				$("#table").append("<tr><td>"+o.row+"</td>"+"<td>"+o.teamname+"</td>"+"<td>"+o.position+"</td>"+"<td>"+o.name+"</td>"+"<td>"+o.reason+"</td>"+"<td>"+o.createDate+"</td></tr>");
			});
		}
	});
	//$("#table tr").each(function(){
	//console.log($(this).find("td").text());
	//})
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


function createExpulsion() {
	let expulsion = {
		playerId: $("#teamlist").val(),
		reason: $("#reason").val()
	}
	$.ajax("/expulsion/create", {
		type: "POST",
		dataType: "json",
		data: JSON.stringify(expulsion),
		headers: {
			"Content-Type": "application/json; charset=utf8"
		}
	}).done((res) => {
		if (res.code == 1) {
			alert(res.msg);
			location.href = "/expulsion";
		} else {
			alert(res.msg);
			$("#name").val("");
			return;
		}
	});

}
