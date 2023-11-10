import {
  CircularProgress_default
} from "./chunk-LHUYGFDK.js";
import {
  createSvgIcon
} from "./chunk-RZ7F6EZ2.js";
import "./chunk-5PEV7G32.js";
import "./chunk-FS6FKVQ3.js";
import {
  require_prop_types,
  styled_default
} from "./chunk-ZK3RYFQF.js";
import {
  __toESM,
  require_react
} from "./chunk-BHZAVQOK.js";

// node_modules/mui-image/es/Image.js
var React = __toESM(require_react());
var import_prop_types = __toESM(require_prop_types());
var _excluded = ["src", "alt", "height", "width", "position", "fit", "style", "className", "showLoading", "errorIcon", "shift", "distance", "shiftDuration", "bgColor", "wrapperStyle", "iconWrapperStyle", "wrapperClassName", "iconWrapperClassName", "duration", "easing", "onLoad", "onError"];
function _extends() {
  _extends = Object.assign ? Object.assign.bind() : function(target) {
    for (var i = 1; i < arguments.length; i++) {
      var source = arguments[i];
      for (var key in source) {
        if (Object.prototype.hasOwnProperty.call(source, key)) {
          target[key] = source[key];
        }
      }
    }
    return target;
  };
  return _extends.apply(this, arguments);
}
function _objectWithoutPropertiesLoose(source, excluded) {
  if (source == null)
    return {};
  var target = {};
  var sourceKeys = Object.keys(source);
  var key, i;
  for (i = 0; i < sourceKeys.length; i++) {
    key = sourceKeys[i];
    if (excluded.indexOf(key) >= 0)
      continue;
    target[key] = source[key];
  }
  return target;
}
var BrokenImageIcon = createSvgIcon(React.createElement("path", {
  d: "M21 5v6.59l-2.29-2.3c-.39-.39-1.03-.39-1.42 0L14 12.59 10.71 9.3a.9959.9959 0 0 0-1.41 0L6 12.59 3 9.58V5c0-1.1.9-2 2-2h14c1.1 0 2 .9 2 2zm-3 6.42 3 3.01V19c0 1.1-.9 2-2 2H5c-1.1 0-2-.9-2-2v-6.58l2.29 2.29c.39.39 1.02.39 1.41 0l3.3-3.3 3.29 3.29c.39.39 1.02.39 1.41 0l3.3-3.28z"
}), "BrokenImageIcon");
var Img = styled_default("img")({
  "@keyframes materialize": {
    "0%": {
      filter: "saturate(20%) contrast(50%) brightness(120%)"
    },
    "75%": {
      filter: "saturate(60%) contrast(100%) brightness(100%)"
    },
    "100%": {
      filter: "saturate(100%) contrast(100%) brightness(100%)"
    }
  }
});
function Image(props) {
  var _shiftStyles;
  var src = props.src, alt = props.alt, height = props.height, width = props.width, position = props.position, fit = props.fit, style = props.style, className = props.className, showLoading = props.showLoading, errorIcon = props.errorIcon, shift = props.shift, distance = props.distance, shiftDuration = props.shiftDuration, bgColor = props.bgColor, wrapperStyle = props.wrapperStyle, iconWrapperStyle = props.iconWrapperStyle, wrapperClassName = props.wrapperClassName, iconWrapperClassName = props.iconWrapperClassName, duration = props.duration, easing = props.easing, onLoadProp = props.onLoad, onErrorProp = props.onError, rest = _objectWithoutPropertiesLoose(props, _excluded);
  var _React$useState = React.useState(false), loaded = _React$useState[0], setLoaded = _React$useState[1];
  var _React$useState2 = React.useState(false), error = _React$useState2[0], setError = _React$useState2[1];
  function handleLoad() {
    setLoaded(true);
    setError(false);
    if (Boolean(onLoadProp))
      onLoadProp();
  }
  function handleError() {
    setError(true);
    setLoaded(false);
    if (Boolean(onErrorProp))
      onErrorProp();
  }
  var shiftStyles = (_shiftStyles = {}, _shiftStyles[shift] = loaded ? 0 : distance, _shiftStyles);
  var styles = {
    root: _extends({
      width,
      height,
      display: "flex",
      justifyContent: "center",
      alignItems: "center",
      backgroundColor: bgColor
    }, wrapperStyle),
    image: _extends({
      position,
      width: "100%",
      height: "100%",
      objectFit: fit,
      transitionProperty: (Boolean(shift) ? shift + ", " : "") + "opacity",
      transitionDuration: (Boolean(shift) ? (shiftDuration || duration * 0.3) + "ms, " : "") + duration / 2 + "ms",
      transitionTimingFunction: easing,
      opacity: loaded ? 1 : 0,
      animation: loaded ? "materialize " + duration + "ms 1 " + easing : ""
    }, Boolean(shift) && shiftStyles, style),
    icons: _extends({
      width: "100%",
      marginLeft: "-100%",
      display: "flex",
      justifyContent: "center",
      alignItems: "center",
      opacity: loaded ? 0 : 1
    }, iconWrapperStyle)
  };
  var showErrorIcon = typeof errorIcon !== "boolean" && errorIcon || React.createElement(BrokenImageIcon, {
    style: {
      fontSize: 56,
      color: "#bdbdbd"
    }
  });
  var loadingIndicator = typeof showLoading !== "boolean" && showLoading || React.createElement(CircularProgress_default, {
    size: 56,
    thickness: 6
  });
  return React.createElement("div", {
    style: styles.root,
    className: "mui-image-wrapper " + wrapperClassName
  }, React.createElement(Img, _extends({
    src,
    alt,
    style: styles.image,
    className: "mui-image-img " + className,
    onLoad: handleLoad,
    onError: handleError
  }, rest)), (Boolean(showLoading) || Boolean(errorIcon)) && React.createElement("div", {
    style: styles.icons,
    className: "mui-image-iconWrapper " + iconWrapperClassName
  }, Boolean(errorIcon) && error && showErrorIcon, Boolean(showLoading) && !error && !loaded && loadingIndicator));
}
Image.defaultProps = {
  alt: "",
  height: "100%",
  width: "100%",
  position: "relative",
  fit: "cover",
  showLoading: false,
  errorIcon: true,
  shift: false,
  distance: 100,
  shiftDuration: null,
  bgColor: "inherit",
  duration: 3e3,
  easing: "cubic-bezier(0.7, 0, 0.6, 1)",
  // "heavy move" from https://sprawledoctopus.com/easing/
  className: "",
  wrapperClassName: "",
  iconWrapperClassName: ""
};
Image.propTypes = true ? {
  src: import_prop_types.default.string.isRequired,
  alt: import_prop_types.default.string,
  height: import_prop_types.default.oneOfType([import_prop_types.default.number, import_prop_types.default.string]),
  width: import_prop_types.default.oneOfType([import_prop_types.default.number, import_prop_types.default.string]),
  style: import_prop_types.default.object,
  className: import_prop_types.default.string,
  showLoading: import_prop_types.default.oneOfType([import_prop_types.default.bool, import_prop_types.default.node]),
  errorIcon: import_prop_types.default.oneOfType([import_prop_types.default.bool, import_prop_types.default.node]),
  shift: import_prop_types.default.oneOf([false, null, "top", "bottom", "left", "right"]),
  distance: import_prop_types.default.oneOfType([import_prop_types.default.number, import_prop_types.default.string]),
  shiftDuration: import_prop_types.default.number,
  bgColor: import_prop_types.default.string,
  wrapperStyle: import_prop_types.default.object,
  iconWrapperStyle: import_prop_types.default.object,
  wrapperClassName: import_prop_types.default.string,
  iconWrapperClassName: import_prop_types.default.string,
  duration: import_prop_types.default.number,
  easing: import_prop_types.default.string,
  onLoad: import_prop_types.default.func,
  onError: import_prop_types.default.func,
  position: import_prop_types.default.oneOf(["static", "relative", "absolute", "fixed", "sticky", "inherit", "initial", "revert", "unset"]),
  fit: import_prop_types.default.oneOf(["contain", "cover", "fill", "none", "scale-down", "inherit", "initial", "revert", "unset"])
} : {};

// node_modules/mui-image/es/index.js
var es_default = Image;
export {
  Image,
  es_default as default
};
//# sourceMappingURL=mui-image.js.map
