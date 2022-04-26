<%--
  Created by IntelliJ IDEA.
  User: CongTan
  Date: 26/04/2022
  Time: 5:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <style type="text/css">
        .form {
            height: 20px;
            width: 400px;
            margin: 0;
            padding: 10px;
            border: 3px #CCC solid;
          border-radius: 16px;
        }

        .form input {
            padding: 5px;
            margin: 5px
        }

        .button {
            width: 56px;
            height: 56px;
            left: 18px;
            top: 240px;
            border: none;
            /* M3/sys/light/primary-container */

            background: #0b1121;
            border-radius: 16px;

            box-shadow: 0px 4px 8px 3px rgba(0, 0, 0, 0.15);
            filter: drop-shadow(0px 1px 3px rgba(0, 0, 0, 0.3));
        }

        .btn {
            padding-top: 10px;
          width: 106px;
          height: 106px;
        }
        .hmm {
          display: inline;
        }
        .text{
          width: 306px;
          height: 56px;
          left: 18px;
          top: 240px;

          border-radius: 16px;

          box-shadow: 0px 4px 8px 3px rgba(0, 0, 0, 0.15);
          filter: drop-shadow(0px 1px 3px rgba(0, 0, 0, 0.3));
        }
    </style>
</head>
<body>
<h2>Calculator</h2>
<form class="form" action="/calculator" method="get">
    <input class="text" type="text" name="num1" placeholder="Number 1"/><br>
    <input class="text" type="text" name="num2" placeholder="Number 2"/><br>
  <div class="hmm">
    <table>
      <tr>
        <td>
          <div class="btn">
            <button class="button" type="submit" name="calculator" value="Addition">
              <svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <path d="M11.883 3.007 12 3a1 1 0 0 1 .993.883L13 4v7h7a1 1 0 0 1 .993.883L21 12a1 1 0 0 1-.883.993L20 13h-7v7a1 1 0 0 1-.883.993L12 21a1 1 0 0 1-.993-.883L11 20v-7H4a1 1 0 0 1-.993-.883L3 12a1 1 0 0 1 .883-.993L4 11h7V4a1 1 0 0 1 .883-.993L12 3l-.117.007Z"
                      fill="#ffffff"/>
              </svg>
            </button>
          </div>
        </td>
        <td>
          <div class="btn">
            <button class="button" type="submit" name="calculator" value="Subtraction">
              <svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <path d="M3.997 13H20a1 1 0 1 0 0-2H3.997a1 1 0 1 0 0 2Z" fill="#ffffff"/>
              </svg>
            </button>
          </div>
        </td>
        <td>
          <div class="btn">
            <button class="button" type="submit" name="calculator" value="Multiplication">
              <svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <path d="m4.21 4.387.083-.094a1 1 0 0 1 1.32-.083l.094.083L12 10.585l6.293-6.292a1 1 0 1 1 1.414 1.414L13.415 12l6.292 6.293a1 1 0 0 1 .083 1.32l-.083.094a1 1 0 0 1-1.32.083l-.094-.083L12 13.415l-6.293 6.292a1 1 0 0 1-1.414-1.414L10.585 12 4.293 5.707a1 1 0 0 1-.083-1.32l.083-.094-.083.094Z"
                      fill="#ffffff"/>
              </svg>
            </button>
          </div>
        </td>
        <td>
          <div class="btn">
            <button class="button" type="submit" name="calculator" value="Division">
              <svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <path d="M11 3v18a1 1 0 1 0 2 0V3a1 1 0 1 0-2 0Z" fill="#DDE6E8"/>
              </svg>
            </button>
          </div>
        </td>
      </tr>
    </table>
  </div>
</form>
</body>
</html>
