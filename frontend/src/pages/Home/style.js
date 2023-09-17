import styled from "styled-components";

export const MapViewArea = styled.section`
  width: 100%;
  height: 100vh;
`;

export const MapView = styled.div`
  width: 100%;
  height: 100%;
`;

export const ContentArea = styled.section`
  position: fixed;
  top: 3.5rem;
  right: 0;
  z-index: 10;
  width: 28rem;
  height: calc(100vh - 3.5rem);
  overflow-y: scroll;

  background-color: #ffffff;
  box-shadow: -4px 0 8px rgba(0, 0, 0, 0.25);

  @media (max-width: 832px) {
    width: 100%;
  }
`;
