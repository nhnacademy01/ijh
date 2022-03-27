window.addEventListener("load",function(){    
    init();
});

async function init(){
    const  itemList =  await getData();
    tableGo(itemList.items);
    graph(itemList.items);
}

const serviceKey = "TRAmFKMCSjC9ykoDhAnTe9a5MiXB2pIJqpkGTKUJGAqOU9luUNKn8Lf%2FnZDHRU34OmzbOwXzXcSHfRIcHc8XZQ%3D%3D";
async function  getData(){    
    const url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson'; /*URL*/
    let queryParams = '?' + encodeURIComponent('serviceKey') + '='+serviceKey; /*Service Key*/
    queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
    queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
    queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent('20200302'); /**/
    queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent('20200320'); /**/

    const result = {
        items :[]
    };

    await fetch(url + queryParams )
        .then(response => response.text())
        .then(data => new window.DOMParser().parseFromString(data, "text/xml"))
        .then(body => body.getElementsByTagName("body"))
        .then( function(body){
            const numOfRows = body[0].getElementsByTagName("numOfRows")[0].innerHTML;
            const pageNo    = body[0].getElementsByTagName("pageNo")[0].innerHTML;
            const totalCount = body[0].getElementsByTagName("totalCount")[0].innerHTML;

            result.numOfRows = numOfRows;
            result.pageNo = pageNo;
            result.totalCount = totalCount;
            
            const items = body[0].getElementsByTagName("item");
            
                for(let i=0; i<items.length; i++){
                    //일자
                    let createDt = items[i].getElementsByTagName("createDt")[0].innerHTML;
                    //사망자수
                    let deathCnt = items[i].getElementsByTagName("deathCnt")[0].innerHTML;
                    //누적확진자
                    let decideCnt = items[i].getElementsByTagName("decideCnt")[0].innerHTML;
                    let seq = items[i].getElementsByTagName("seq")[0].innerHTML;
                    let stateDt = items[i].getElementsByTagName("stateDt")[0].innerHTML;
                    let stateTime = items[i].getElementsByTagName("stateTime")[0].innerHTML;
                    let updateDt = items[i].getElementsByTagName("updateDt")[0].innerHTML;
                    let accDefRate = items[i].getElementsByTagName("accDefRate")[0].innerHTML;

                    const item = {
                        createDt,
                        deathCnt,
                        decideCnt,
                        seq,
                        stateDt,
                        stateTime,
                        updateDt,
                        accDefRate,
                       // accExamCnt
                    }
                    
                    result.items.push(item);
                }
                result.items;
            }
        )
        .catch((error) => {console.log(error)} );

    return result;

}

function tableGo(itemList) {
    let tbodyId = document.getElementById("tbodyId");
    
    for (let i = 0; i < itemList.length; i++) {
        tbodyId.innerHTML += 
        `
        <tr>
            <td>${itemList[i].stateDt}</td>
            <td>${itemList[i].accDefRate}</td>
            <td>${itemList[i].deathCnt}</td>
            <td>${itemList[i].updateDt}</td>
        </tr>
        `;
    }
}

function graph(itemList) {
    var deadNum = [];
    var addCovid = [];
    var statDay = [];
            
    for(let i=0;i<itemList.length;i++){
        statDay[i]=itemList[i].stateDt;
        deadNum[i]=itemList[i].deathCnt;
        addCovid[i]=itemList[i].accExamCnt;
    }


    var ctx = document.getElementById('myChart').getContext('2d');
    var chart = new Chart(ctx, {
        type: 'line',
        data:{
            labels:statDay,
            datasets:[{
                label: '누적 사망자 수',
                backgroundColor:'transparent',
                borderColor:'blue',
                data: deadNum
            },
            {
                label: '누적 확진자 수',
                backgroundColor:'transparent',
                borderColor:'red',
                data: addCovid
            }
        ]},
        options:{}
    });

}