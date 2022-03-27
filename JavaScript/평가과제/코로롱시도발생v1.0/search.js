let serviceKey = "OS4U4zQ8fMWfUZpyrjOX85mRqdFBCBkLk7pqagaoxcG1Bm9%2B73ZpV6LgRYjqCPCDF%2FKEC5BHbZ272zU%2BUwOTWQ%3D%3D";

var xhr = new XMLHttpRequest();
var url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '=' + serviceKey; /*Service Key*/
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent('20220301'); /**/
queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent('20220326'); /**/
xhr.open('GET', url + queryParams);

let itemList = [];
let cityArray = []

fetch(url + queryParams)
    .then(response => response.text())
    .then(data => new window.DOMParser().parseFromString(data, "text/xml"))
    .then(data => data.getElementsByTagName("item"))
    .then(function (items) {
        for (let i = 0; i < items.length; i++) {
            cityArray.push(items[i].getElementsByTagName("gubun")[0].innerHTML)
        }

        for (let i = 0; i < items.length; i++) {
            let createDt = items[i].getElementsByTagName("createDt")[0].innerHTML;
            let defCnt = items[i].getElementsByTagName("defCnt")[0].innerHTML;
            let incDec = items[i].getElementsByTagName("incDec")[0].innerHTML;
            let updateDt = items[i].getElementsByTagName("updateDt")[0].innerHTML;

            let item = {
                createDt,
                defCnt,
                incDec,
                updateDt,
            }
            itemList.push(item);
            i+=18;
        }
        itemList = itemList.reverse();
        OnLoadTable();
    }
    ).catch((error) => { console.log(error) });


function OnLoadTable() {
    const hTbody = document.getElementById('htmlTbody');

    for (let i = 0; i < itemList.length; i++) {
        const newRow0 = hTbody.insertRow();
        newRow0.insertCell();
        newRow0.insertCell();
        newRow0.insertCell();
        newRow0.insertCell();

        hTbody.rows[i].cells[0].innerHTML = itemList[i].createDt
        hTbody.rows[i].cells[1].innerHTML = itemList[i].defCnt
        hTbody.rows[i].cells[2].innerHTML = itemList[i].incDec
        hTbody.rows[i].cells[3].innerHTML = itemList[i].updateDt
    }
}