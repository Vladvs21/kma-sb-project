package com.example.financial_manager.securityConfig.jwt;

//@Component
//@RequiredArgsConstructor
public class JwtAuthFilter {//extends OncePerRequestFilter {


//    private final UserDao userDao;
//    private final JwtUtil jwtUtil;
//    @Override
//    protected void doFilterInternal(@NotNull HttpServletRequest request,
//                                    @NotNull HttpServletResponse response,
//                                    @NotNull FilterChain filterChain) throws ServletException, IOException {
//        final String authHeader = request.getHeader(AUTHORIZATION);
//        final String userLogin;
//        final String jwtToken;
//
//        if(authHeader == null || authHeader.startsWith("Bearer")){
//            filterChain.doFilter(request, response);
//            return;
//        }
//        jwtToken = authHeader.substring(7);
//        userLogin = jwtUtil.extractUsername(jwtToken);
//        if(userLogin != null && SecurityContextHolder.getContext().getAuthentication() == null){
//            UserDetails userDetails = userDao.findUserByUsername(userLogin);
//            final boolean isTokenValid = jwtUtil.validateToken(jwtToken,userDetails);
//            if(isTokenValid){
//                UsernamePasswordAuthenticationToken authenticationToken =
//                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            }
//            filterChain.doFilter(request,response);
//        }
//    }
}
