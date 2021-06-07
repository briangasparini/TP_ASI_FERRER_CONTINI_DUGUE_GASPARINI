function mapToJson(map){ 
    let jsonObject = {};  
    map.forEach((value, key) => {  
        jsonObject[key] = value  
    }); 
    return jsonObject;
}

function sendApiRequest (urlApi,type,parameter){
    var XHR = new XMLHttpRequest();
    var urlEncodedData = "";
    var urlEncodedDataPairs = [];
    // Gestion de la réponse
    XHR.addEventListener('load', function(event) {
        alert('Ouais ! Données envoyées et réponse chargée.');
        fillTemplate(JSON.parse(XHR.response));
        return "OK";
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
     XHR.setRequestHeader('encoded-token',"ZG9kb2FzdGljb3QvbG5qa24tNTQxLzA=");
     XHR.send(JSON.stringify(mapToJson(parameter)));
}