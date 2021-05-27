function sendApiRequest (urlApi,type,parameter){
    var XHR = new XMLHttpRequest();
    var urlEncodedData = "";
    var urlEncodedDataPairs = [];
    // Gestion de la réponse
    XHR.addEventListener('load', function(event) {
        alert('Ouais ! Données envoyées et réponse chargée.');
        fillCardHtml(JSON.parse(XHR.response));
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

function mapToJson(map){ 
    let jsonObject = {};  
    map.forEach((value, key) => {  
        jsonObject[key] = value  
    }); 
    return jsonObject;
}

function getInfoCard(){
    console.log("Tentative de connexion");
    let requestURL = "http://localhost:8081/cards/0";
    var parameter = new Map();
    var cardJson = new String()
    cardJson = sendApiRequest(requestURL,"GET",parameter);
}

function fillCardHtml(cardObject){
    document.getElementById('cardPriceId').innerHTML=cardObject['prix']
    document.getElementById('cardDefenceId').innerHTML=cardObject['defense']
    document.getElementById('cardAttackId').innerHTML=cardObject['attack']
    document.getElementById('cardEnergyId').innerHTML=cardObject['energy']
    document.getElementById('cardDescriptionId').innerHTML=cardObject['description']
    document.getElementById('cardImgId').src=cardObject['imgUrl']
    document.getElementById('cardNameId').innerHTML=cardObject['name']
    document.getElementById('cardFamilyId').innerHTML=cardObject['family']
    document.getElementById('cardHPId').innerHTML=cardObject['hp']
}

window.addEventListener("load", () => {
    this.getInfoCard()
});
