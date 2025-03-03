# Lab: Calling External APIs with Synchronization Blocks

## Objective:
The objective of this lab is to interact with two external APIs:
1. **RestCountries API**: To retrieve details about a country based on user input.
2. **Star Wars API**: To retrieve information about a specific Star Wars character (ID 4).

This lab will introduce **synchronization blocks** using two locks to ensure thread-safe API calls.

## Required Libraries:
1. **HttpClient**: For making HTTP requests.
2. **Gson**: For parsing JSON responses.

Add Gson dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.11.0</version>
</dependency>
```

## API Documentation:
1. **RestCountries API**: [https://restcountries.com/](https://restcountries.com/)
2. **Star Wars API**: [https://swapi.dev/](https://swapi.dev/)

---

## Step 1: Implement Thread-Safe API Calls

- You will implement **two synchronized API calls** using separate locks.
- One thread will call the **RestCountries API**.
- Another thread will call the **Star Wars API** if the country is not found.

### API Endpoint for RestCountries API:
- URL: `https://restcountries.com/v3.1/name/{country}` (replace `{country}` with the name of the country)

### API Endpoint for Star Wars API:
- URL: `https://swapi.dev/api/people/4/`

### Task 1: Fetch Country Details
1. Take user input for a country name.
2. Create a thread that makes an API request to **RestCountries API**.
3. Synchronize access to the API call using a **synchronization block** with a dedicated lock.
4. If the country is found, print details in the format:

   ```
   {name} country is a great country with a great population of {population} and is in {continent} continent. With the following capitals: {capital}
   ```

5. If the country is **not found**, trigger a second API request to the **Star Wars API**.

### Task 2: Fetch Star Wars Character
1. If the country is **not found**, create another thread that calls the **Star Wars API**.
2. Synchronize access to this API call using another **synchronization block** with a different lock.
3. Print the name of the Star Wars character in any format you like.

---

## Deliverables:
1. **Thread-Safe API Calls**:
   - Use **two locks** to synchronize API requests.
   - Call the RestCountries API first.
   - If the country is not found, call the Star Wars API in a separate thread.

2. **Correct Output Handling**:
   - Display the country details if found.
   - If not found, display the Star Wars character information.

3. **Optional Challenge**:
   - Implement error handling for API failures (e.g., network issues, API downtime).
   - Allow users to make multiple queries without restarting the program.

---

### Example Scenarios:
#### Case 1: User enters `USA`
```
USA is a great country with a great population of 331002651 and is in North America continent. With the following capitals: Washington, D.C.
```

#### Case 2: User enters `Wakanda`
```
Country not found. Fetching alternative information...
Darth Vader is a powerful Sith Lord.
```

