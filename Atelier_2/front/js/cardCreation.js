

function addCard(){
    console.log("Tentative de connexion");
    let requestURL = "http://localhost:8081/cards";
    var parameter = new Map();
    parameter.set("name",document.getElementById("lname").value);
    parameter.set("description",document.getElementById("ldescription").value);
    parameter.set("family",document.getElementById("lfamily").value.split('.')[0]);
    parameter.set("affinity",document.getElementById("laffinity").value.split(' 0')[0]);
    parameter.set("imgUrl",document.getElementById("lurl").value);
    parameter.set("hp",document.getElementById("lhp").value);
    parameter.set("energy",document.getElementById("lenergy").value);
    parameter.set("attack",document.getElementById("lattack").value);
    parameter.set("defense",document.getElementById("ldefence").value);
    parameter.set("prix",document.getElementById("lprix").value);
    parameter.set("owner",0);
    console.log(JSON.stringify(mapToJson(parameter)));
    //sendApiRequest(requestURL,"POST",parameter);
}