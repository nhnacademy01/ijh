let label1 = []
let decideCnt = [];
let deathCnt = [];

function DrawChart() {
    for (let i = 0; i < itemList.length; i++) {
        label1.push(itemList[i].stateDt)
        decideCnt.push(itemList[i].decideCnt)
        deathCnt.push(itemList[i].deathCnt)
    }
    
    const data = {
        labels: label1,
        datasets: [
            {
                label: '확진자(누적)',
                backgroundColor: 'rgb(255, 0, 0)',
                borderColor: 'rgb(255, 0, 0)',
                data: decideCnt,
            },
            {
                label: '사망자(누적)',
                backgroundColor: 'rgb(0, 255, 255)',
                borderColor: 'rgb(0, 255, 255)',
                data: deathCnt,
            }
        ]
    };
    
    const config = {
        type: 'line',
        data: data,
        options: {}
    };
    
    const myChart = new Chart(
        document.getElementById('myChartOne').getContext('2d'),
        config
    );
}

