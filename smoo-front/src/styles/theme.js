import React from 'react';
import PropTypes from 'prop-types';
import { ThemeProvider } from 'styled-components';

import media from './media';

const Theme = ({ children }) => (
  <ThemeProvider
    theme={{ primaryFont: 'Arial', primaryColor: '#666', ...media }}
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
