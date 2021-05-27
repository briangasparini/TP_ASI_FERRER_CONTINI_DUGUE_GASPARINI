
function sendApiRequest (urlApi,type,parameter){
    var XHR = new XMLHttpRequest();
    var urlEncodedData = "";
    var urlEncodedDataPairs = [];
    // Gestion de la réponse
    XHR.addEventListener('load', function(event) {
        alert('Ouais ! Données envoyées et réponse chargée.');
        alert(XHR.response);
        return JSON.parse(XHR.response);
    });
    // Définissez ce qui arrive en cas d'erreur
    XHR.addEventListener('error', function(event) {
        alert('Oups! Quelque chose s\'est mal passé.');
        return "";
    });
     // Configurez la requête
     XHR.open(type, urlApi);
     // Ajoutez l'en-tête HTTP requise pour requêtes POST de données de formulaire
     XHR.setRequestHeader('Content-Type', 'application/json');
     XHR.send(JSON.stringify(mapToJson(parameter)));
}

function mapToJson(map){ 
    let jsonObject = {};  
    map.forEach((value, key) => {  
        jsonObject[key] = value  
    }); 
    return jsonObject;
}

function checkUser(){
    console.log("Tentative de connexion");
    let requestURL = "http://localhost:8081/login";
    var parameter = new Map();
    parameter.set("login",document.getElementById("flogin").value);
    parameter.set("password",document.getElementById("lpassword").value);
    sendApiRequest(requestURL,"POST",parameter);
}






