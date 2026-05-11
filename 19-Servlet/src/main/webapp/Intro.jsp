<!DOCTYPE html>
<html>
<head>

    <!-- 👉 Request ko completely transfer kar deta hai dusre resource ko -->
<!-- 👉 Dusre resource ka output current response me add karta hai -->
    <meta charset="UTF-8">
    <title>Student Form</title>
    <link rel="stylesheet" href="<%= application.getContextPath() %>/css/style.css">
</head>

<body>
    <form action="submit" method="post">
        <div>
            <h1>Enter Your Name:</h1>
            <input type="text" name="name" placeholder="Enter Your Name">
        </div>

        <div>
            <h1>Enter Your Age:</h1>
            <input type="number" name="age" placeholder="Enter Your Age">
        </div>

        <div>
            <h1>Enter Your Branch:</h1>
            <select name="branch" id="branch">
                <option value="">Select Branch</option>
                <option value="CSE">CSE</option>
                <option value="ME">ME</option>
                <option value="EE">EE</option>
                <option value="Civil">Civil</option>
            </select>
        </div>
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>