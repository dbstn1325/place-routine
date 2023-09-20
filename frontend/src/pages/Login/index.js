import { Anchor, LoginContentArea, LogoImg } from "./style";
import { API_URL } from "../../constants";
import { kakaoLogo } from "../../assets";

const companies = [
  {
    name: "카카오",
    imgSrc: kakaoLogo,
    url: API_URL.LOGIN_KAKAO,
  },
];

export const LoginPage = () => {
  return (
    <LoginContentArea>
      <h2>
        간편하게 로그인하고, <br></br>
        <br></br>더 쉽게 루틴을 추가해봐요 :)
      </h2>
      {companies.map(({ name, imgSrc, url }) => (
        <LogoImg key={name} href={url}>
          <img src={imgSrc} alt={name} />
        </LogoImg>
      ))}
    </LoginContentArea>
  );
};
