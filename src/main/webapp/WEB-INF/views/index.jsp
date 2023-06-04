<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Pokémon Details</title>
    </head>

    <body>
        <h1>Pokémon Details</h1>
        <form action="pokemon" method="GET">
            <label for="pokemonName">Enter Pokémon Name:</label>
            <input type="text" id="pokemonName" name="pokemonName" required>
            <input type="submit" value="Get Details">
        </form>

        <h2>Details:</h2>
        <c:if test="${not empty pokemonDetails}">
            <p>Name: ${pokemonDetails.name}</p>
            <p>Height: ${pokemonDetails.height}</p>
            <p>Weight: ${pokemonDetails.weight}</p>
            <p>Abilities:</p>
            <ul>
                <c:forEach var="ability" items="${pokemonDetails.abilities}">
                    <li>${ability.ability.name}</li>
                </c:forEach>
            </ul>
        </c:if>

        <c:if test="${not empty errorMessage}">
            <p>${errorMessage}</p>
        </c:if>
    </body>

    </html>