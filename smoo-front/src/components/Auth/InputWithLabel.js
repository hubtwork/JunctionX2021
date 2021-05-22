import React from 'react';
import styled from 'styled-components';
import oc from 'open-color';
import PropTypes from 'prop-types';

// 두개가 함께 있을땐 상단 (그 사이) 에 여백을 준다
const Wrapper = styled.div`
  & + & {
    margin-top: 3rem;
  }
`;

const Label = styled.div`
  font-size: 1.6rem;
  color: ${oc.gray[8]};
  font-weight: bold;
  margin-bottom: 1rem;
  padding-left: 1rem;
`;

const Input = styled.input`
  width: 100%;
  border: 1px solid ${oc.gray[3]};
  outline: none;
  border-radius: 0px;
  line-height: 4rem;
  font-size: 1.2rem;
  border-radius: 10rem;
  padding-left: 1rem;
`;

// rest 쪽에는 onChange, type, name, value, placeholder 등의 input 에서 사용 하는 값들을 넣어줄 수 있음
const InputWithLabel = ({ label, ...rest }) => (
  <Wrapper>
    <Label>{label}</Label>
    {/* eslint-disable-next-line react/jsx-props-no-spreading */}
    <Input {...rest} />
  </Wrapper>
);

InputWithLabel.propTypes = {
  label: PropTypes.string.isRequired,
};

export default InputWithLabel;
