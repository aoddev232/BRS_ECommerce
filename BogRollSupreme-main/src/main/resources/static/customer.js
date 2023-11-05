$(document).ready(function() {
    var countElement = $('#cartCount');

// Send an AJAX request to the server to get the count
    $.ajax({
        url: '/cartCount',
        type: 'GET',
        success: function(response) {
            // Update the count element with the retrieved count
            countElement.text(response.count);
        },
        error: function(xhr, status, error) {
            console.log('Error getting count:', error);
        }
    });
});

$(document).ready(function() {
    var totalPrice = $('#totalPrice');

// Send an AJAX request to the server to get the count
    $.ajax({
        url: '/totalPrice',
        type: 'GET',
        success: function(response) {
            // Update the count element with the retrieved count
            totalPrice.text(response.totalPrice);
        },
        error: function(xhr, status, error) {
            console.log('Error getting count:', error);
        }
    });
});

function updateCurrency(thValue) {
    var currencyDisplay = document.getElementById("currency-display");
    value = thValue + '0';
    currencyDisplay.textContent = value;
}
