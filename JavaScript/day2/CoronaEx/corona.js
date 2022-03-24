let serviceKey = "OS4U4zQ8fMWfUZpyrjOX85mRqdFBCBkLk7pqagaoxcG1Bm9%2B73ZpV6LgRYjqCPCDF%2FKEC5BHbZ272zU%2BUwOTWQ%3D%3D";

var xhr = new XMLHttpRequest();
var url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '=' + serviceKey; /*Service Key*/
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent('20220310'); /**/
queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent('20220323'); /**/
xhr.open('GET', url + queryParams);

let itemList = [];
fetch(url + queryParams)

    .then(response => response.text())
    .then(data => new window.DOMParser().parseFromString(data, "text/xml"))
    .then(data => data.getElementsByTagName("item"))
    .then(function (items) {
        for (let i = 0; i < items.length; i++) {
            let decideCnt = items[i].getElementsByTagName("decideCnt")[0].innerHTML;
            let createDt = items[i].getElementsByTagName("createDt")[0].innerHTML;
            let deathCnt = items[i].getElementsByTagName("deathCnt")[0].innerHTML;
            let seq = items[i].getElementsByTagName("seq")[0].innerHTML;
            let stateDt = items[i].getElementsByTagName("stateDt")[0].innerHTML;
            let updateDt = items[i].getElementsByTagName("updateDt")[0].innerHTML;

            let item = {
                decideCnt,
                createDt,
                deathCnt,
                seq,
                stateDt,
                updateDt
            }
            itemList.push(item);
        }
        itemList = itemList.reverse();
        OnLoadTable();
        DrawChart()
    }
    ).catch((error) => { console.log(error) });