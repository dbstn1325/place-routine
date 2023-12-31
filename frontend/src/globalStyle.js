import { createGlobalStyle } from "styled-components";

const GlobalStyle = createGlobalStyle`
  @font-face {
    font-family: 'yg-jal-nan';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff') format('woff');
    font-weight: normal;
    font-style: normal;
  }
  @font-face {
      font-family: 'S-CoreDream-3Light';
      src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-3Light.woff') format('woff');
      font-weight: normal;
      font-style: normal;
  }
  * {
    margin:0;
    padding:0;
    box-sizing: border-box;
    font-family: 'Noto Sans KR', sans-serif;
    color: #aaa;
    letter-spacing: -0.01rem;
  }
  html, body {
    height: 100%;
    cursor: default;
  }
  #root {
    height: 100%;
  }
  a {
    color: inherit;
    text-decoration: none;
    outline: none;
    &:link,
    &:visited,
    &:hover,
    &:active,
    &:focus {
      text-decoration: none;
      color: inherit;
    }
  }
  h2 {
    padding: 1.75rem 0 1.25rem;
    font-family: 'S-CoreDream-3Light', sans-serif;
    font-size: 1.1rem;
    font-weight: 600;
    line-height: 1.1rem;
    color: #555;
    text-align: center;
    letter-spacing: -0.05rem;
  }
  ul {
    list-style-type: none;
  }
  button {
    cursor: pointer;
    border: none;
    background: none;
    font-family: inherit;
    &:disabled {
      cursor: default;
    }
  }
  &::-webkit-scrollbar {
    width: 0.5rem;
    background-color: transparent;
  }
  &::-webkit-scrollbar-track {
    background-color: transparent;
  }
`;

export default GlobalStyle;
