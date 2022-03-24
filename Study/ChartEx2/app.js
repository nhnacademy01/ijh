const labels = [
    'January',
    'February',
    'March',
    'April',
    'May',
    'June',
];

const data = {
    labels: labels,
    datasets: [
    {
        label: '누적 확진자수',
        backgroundColor: 'rgb(255, 0, 0)',
        borderColor: 'rgb(255, 0, 0)',
        data: [0, 10, 5, 2, 20, 30, 45],
    },
    {
        label: '누적 사망자수',
        backgroundColor: 'rgb(0, 255, 255)',
        borderColor: 'rgb(0, 255, 255)',
        data: [1, 3, 5, 2, 20, 30, 45],
    }
]
};

const config = {
    type: 'line',
    data: data,
    options: {}
};

const myChart = new Chart(
    document.getElementById('myChart'),
    config
);