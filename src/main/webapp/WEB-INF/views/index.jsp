<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="css/pokemoncss.css">
    <title>Pokemon Search Engine</title>
</head>

<body>
    <div class="container">
        <div class="search-form">
            <h1>Pokemon Search Engine</h1>
            <form id="input">
                <input type="text" name="pokemon" placeholder="Enter the pokemon name">
                <button type="submit">Search</button>
            </form>
            <div id="search-results">
                <!-- Display search results here -->
            </div>
        </div>
    </div>

    <div class="response-container">
        <div class="response-box">
            <h2>Attributes of Pokemon</h2>
            <p></p>
        </div>

        <div class="response-box">
            <h2>API Response</h2>
            <p>API response will be here</p>
        </div>
    </div>





    <!-- java script for bootstarp -->
    <script>
        $(document).ready(function () {
            // Handle form submission
            $('#input').submit(function (e) {
                e.preventDefault(); // Prevent the default form submission

                var formData = $(this).serialize(); // Get the form data

                // Send AJAX request to the Spring Boot API endpoint
                $.ajax({
                    url: '/api/endpoint' + formData,
                    type: 'POST',
                    success: function (response) {
                        // Handle the API response
                        console.log(response);
                        // Perform any necessary actions based on the response
                    },
                    error: function (error) {
                        // Handle the error
                        console.log(error);
                        // Display an error message or perform any necessary error handling
                    }
                });
            });
        });
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>

</body>

</html>