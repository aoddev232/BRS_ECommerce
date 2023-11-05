window.onload = function () {
    //line chart
    new Chart(document.getElementById("chart1"), {
        type : 'line',
        data : {
            labels : [ 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday' ],
            datasets : [
                {
                    data : dailyEarningCount,
                    label: 'Total Orders',
                    borderColor : "#3cba9f",
                    fill : false,
                    lineTension: 0
                },
                {
                    data : fulfilledDailyEarningCount,
                    label: 'Fulfilled Orders',
                    borderColor : "#f34a12",
                    fill : false,
                    lineTension: 0
                }
            ]
        },
        options : {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            },
            title : {
                display : true,
                text : 'Daily Sales ($)'
            }
        }
    });

    //first bar chart
    new Chart(document.getElementById("chart2"), {
    type: 'bar',
    data: {
    labels: topSkus,
    datasets: [
{
    label: "Count",
    backgroundColor: ["#51EAEA", "#FCDDB0", "#FF9D76", "#FB3569", "#82CD47"],
    data: topSkusCounts
}]
},
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        },
    indexAxis: 'y',
    legend: {
    display: false
},
    title: {
    display: true,
    text: 'Best Selling Models by SKU'
}
}
});

    //second bar chart
    new Chart(document.getElementById("chart3"), {
    type: 'bar',
    data: {
    labels: ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"],
    datasets: [
{
    label: "$",
    backgroundColor: ["#51EAEA", "#FCDDB0", "#FF9D76", "#FB3569", "#82CD47", "#1313F2", "#12AF31"],
    data: dailyEarningCount
}]
},
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        },
    indexAxis: 'y',
    legend: {
    display: false
},
    title: {
    display: true,
    text: 'Best Sales Days'
}
}
});
}