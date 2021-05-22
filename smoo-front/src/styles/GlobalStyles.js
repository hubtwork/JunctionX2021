import { createGlobalStyle } from 'styled-components';
import reset from 'styled-reset';

const GlobalStyles = createGlobalStyle`
  ${reset};
  *{
        box-sizing:border-box;
        -moz-box-sizing: border-box;
        -webkit-box-sizing: border-box;
        // 드래그를 막아주는 속성
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
  }
  html {
        // 1rem을 10px로 설정
      font-size: 62.5%;
  }
  body{

        font-family: 'NanumSquare', sans-serif; 

  }
  a{
        text-decoration:none;
        color:inherit;
        cursor: pointer;
    }
    ol, ul, li {
        list-style: none;
    }
    input, button {
        -webkit-appearance: none;
        background-color: transparent;
        border: none;
        outline: none;
        cursor: pointer;
    }
    input {

        -webkit-user-select: text;
        -moz-user-select: text;
        -ms-user-select: text;
        user-select: text;
    }
`;

export default GlobalStyles;
