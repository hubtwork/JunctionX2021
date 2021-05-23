import React from 'react';
import styled from 'styled-components';
import oc from 'open-color';
import { Link } from 'react-router-dom';
import PropTypes from 'prop-types';
import { shadow } from '../../styles/styleUtil';
// 화면의 중앙에 위치시킨다
const Positioner = styled.div`
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
`;

// 너비, 그림자 설정
const ShadowedBox = styled.div`
  width: 42rem;
  ${shadow(0)}
  display: flex;
  flex-direction: column;
  align-items: center;
  border-radius: 2rem;
`;

// children 이 들어가는 곳
const Contents = styled.div`
  background: white;
  padding: 6rem 5rem;
  height: auto;
  border-radius: 2rem;
`;

const AuthWrapper = ({ children }) => (
  <Positioner>
    <ShadowedBox>
      <Contents>{children}</Contents>
    </ShadowedBox>
  </Positioner>
);

AuthWrapper.propTypes = {
  children: PropTypes.oneOfType([
    PropTypes.arrayOf(PropTypes.node),
    PropTypes.node,
  ]).isRequired,
};
export default AuthWrapper;
