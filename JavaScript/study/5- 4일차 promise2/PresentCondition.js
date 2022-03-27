window.addEventListener("load",function(){
    getData()
    .then(parse)
    .then(makeTable)
    .then(viewChart)
});

let serviceKey="js1GWFjIfrERmyn6iseWSBQOMm4yyWL%2FsJ3UOSnM3AcehLdRfNBr8yRgrSyo2%2FIeeljSyCOphlcWM0zzs6D9bg%3D%3D";
function getData(){
    return new Promise(function(resolve, reject){
        const xhr = new XMLHttpRequest();
        const url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"; /*URL*/
        let queryParams = "?" + encodeURIComponent("serviceKey") + "=" + serviceKey; /*Service Key*/
        queryParams += "&" + encodeURIComponent("pageNo") + "=" + encodeURIComponent("1"); /**/
        queryParams += "&" + encodeURIComponent("numOfRows") + "=" + encodeURIComponent("10"); /**/
        queryParams += "&" + encodeURIComponent("startCreateDt") + "=" + encodeURIComponent("20220301"); /**/
        queryParams += "&" + encodeURIComponent("endCreateDt") + "=" + encodeURIComponent("20220324"); /**/
        xhr.open("GET", url + queryParams);
        xhr.onreadystatechange = function () {

            if(this.readyState == 4){
                if(this.status == 200){
                    let msg = this.responseXML.getElementsByTagName("resultMsg")[0].innerHTML;
                    if(msg=="NORMAL SERVICE."){
                        resolve(this.responseXML);
                    }else{
                        reject(new Error(msg));
                    }
                }else if(this.status == 403){
                    reject(new Error("Forbidden"));
                }else if(this.status == 404){
                    reject(new Error("Not Found"));
                }else if(this.status == 500 ){
                    reject(new Error("Internal Server Error"));
                }else{
                    reject(new Error("Unknown Error"));
                }
            }

        };
        xhr.send("");
    });
}

function parse(xmlDoc){
    return new Promise(function(resolve, reject){
        let items = xmlDoc.getElementsByTagName("item");
        let itemList = [];
        for (let i = 0; i < items.length; i++) {
            let decideCnt = items[i].getElementsByTagName("decideCnt")[0].innerHTML;
            let createDt = items[i].getElementsByTagName("createDt")[0].innerHTML;
            let deathCnt = items[i].getElementsByTagName("deathCnt")[0].innerHTML;
            let seq = items[i].getElementsByTagName("seq")[0].innerHTML;
            let stateDt = items[i].getElementsByTagName("stateDt")[0].innerHTML;
            let updateDt = items[i].getElementsByTagName("updateDt")[0].innerHTML;
            let accExamCnt =decideCnt;

            let item = {
                decideCnt,
                createDt,
                deathCnt,
                seq,
                stateDt,
                updateDt,
                accExamCnt
            };
            itemList.push(item);
        }
        resolve(itemList);
    })
}

function makeTable(itemList) {

    return new Promise(function(resolve, reject){
        let tableContent = document.getElementById("tbody");

        for (let i = 0; i < itemList.length; ++i) {
            
            let contentTd = `
            <tr>
            <td>${itemList[i].createDt}</td>
            <td>${itemList[i].accExamCnt}</td>
            <td>${itemList[i].deathCnt}</td>
            <td>${itemList[i].updateDt}</td>
            </tr>
            `;

            tableContent.insertAdjacentHTML("beforeend",contentTd);
        }
        resolve(itemList);
    })
}

function viewChart(itemList){
    
    return new Promise(function(resolve,reject){
        
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);
    
        function drawChart() {
        let googleDataList = new Array();
    
        for (let i = 0; i < itemList.length; ++i) {
            dataList = new Array(3);
            dataList[0] = itemList[i].createDt.substr(0, 10);
            dataList[1] = Number(itemList[i].accExamCnt);
            dataList[2] = Number(itemList[i].deathCnt);
    
            googleDataList.push(dataList);
            }

            var data = new google.visualization.DataTable();

            data.addColumn('string', 'Day');
            data.addColumn('number', '확진자 수');
            data.addColumn('number', '사망자 수');

            data.addRows(googleDataList);
    
            var options = {
            title: '코로나 19 현황',
            curveType: 'function',
            legend: { position: 'top' },
            height:500,
            width:'100%',
            pointSize: 5,

            };
    
            var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
    
            chart.draw(data, options);
        }

    });

}


