
$("#stadiumlist").click(()=>{
});

$("#btnConfirm").click(()=>{
	createTeam();
});


function createTeam(){
	let team = {
		name:$("#name").val(),
		stadiumId:$("#stadiumlist").val(),
		
	}
	
	$.ajax("/team/create", {
		type: "POST",
		dataType: "json",
		data:JSON.stringify(team),
		headers:{
			"Content-Type":"application/json; charset=utf8"
		}
	}).done((res)=>{
		if(res.code == 1){
			alert("팀이 생성되었습니다.");
			location.href="/team";
		}else{
			alert(res.msg);
			$("#name").val("");
			return;
		}
	});
}