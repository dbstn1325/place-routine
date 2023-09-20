import styled from "styled-components";

import { COLOR, LAYOUT, Z_INDEX } from "../../constants";

export const LoginContentArea = styled.section`
  width: ${LAYOUT.LOGIN_WIDTH};
  height: calc(100% - ${LAYOUT.NAV_HEIGHT});
  margin: 20% auto;
  text-align: center;
  display: flex;
  flex-direction: column;
  justify-content: center;

  @media (max-width: 832px) {
    width: 100%;
  }
`;

export const LogoImg = styled.a`
  margin-top: 5rem;
`;
