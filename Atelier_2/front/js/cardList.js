function fillTemplate(cardList){
    let template = document.querySelector("#row");

    for(const card of cardList){
        let clone = document.importNode(template.content, true);
    
        newContent= clone.firstElementChild.innerHTML
                    .replace(/{{family_src}}/g, card.imgUrl)
                    .replace(/{{family_name}}/g, card.family)
                    .replace(/{{img_src}}/g, card.imgUrl)
                    .replace(/{{name}}/g, card.name)
                    .replace(/{{description}}/g, card.description)
                    .replace(/{{hp}}/g, card.hp)
                    .replace(/{{energy}}/g, card.energy)
                    .replace(/{{attack}}/g, card.attack)
                    .replace(/{{defense}}/g, card.defense)
                    .replace(/{{price}}/g, card.prix);
        clone.firstElementChild.innerHTML= newContent;
    
        let cardContainer= document.querySelector("#tableContent");
        cardContainer.appendChild(clone);
    }
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

function mapToJson(map){ 
    let jsonObject = {};  
    map.forEach((value, key) => {  
        jsonObject[key] = value  
    }); 
    return jsonObject;
}

function getCardList(){
    console.log("Tentative de connexion");
    let requestURL = "http://localhost:8081/users/0/cards";
    var parameter = new Map();
    var cardJson = new String();
    cardJson = sendApiRequest(requestURL,"GET",parameter);
}

window.addEventListener("load", (event) => {
    this.getCardList()
});
