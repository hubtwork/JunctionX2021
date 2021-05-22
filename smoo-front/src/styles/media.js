import { css } from 'styled-components';

const sizes = {
  mobile: 320,
  tablet: 768,
  desktop: 1024,
};

export default Object.keys(sizes).reduce((acc, label) => {
  acc[label] = (...args) => css`
    @media (min-width: ${sizes[label]}px) {
      ${css(...args)};
    }
  `;
  return acc;
}, {});
