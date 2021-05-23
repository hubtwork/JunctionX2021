import React from 'react';
import PropTypes from 'prop-types';
import { ThemeProvider } from 'styled-components';

import styleUtil from './styleUtil';

const Theme = ({ children }) => (
  <ThemeProvider
    theme={{ primaryFont: 'Arial', primaryColor: '#666', ...styleUtil }}
  >
    {children}
  </ThemeProvider>
);

Theme.propTypes = {
  children: PropTypes.oneOfType([
    PropTypes.arrayOf(PropTypes.node),
    PropTypes.node,
  ]).isRequired,
};

export default Theme;
