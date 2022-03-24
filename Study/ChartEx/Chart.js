let myChartOne = document.getElementById('myChartOne').getContext('2d');

let lineChart = new Chart(myChartOne, {
    type: 'line', // pie, line, doughnut, polarArea
    data: {
        labels: ['학원', '연구원', '출판사', '미디어서', '위니브'],
        datasets: [{
            label: '바울랩 매출액',
            data: [
                10,
                100,
                100,
                200,
                1000
            ] 
        }]
    }
})