@echo off
echo ========================================
echo  LINE'S REVENGE API - DATABASE SEEDER
echo ========================================
echo.

set BASE_URL=http://localhost:8080/revenge-api

echo Verificando que la API este funcionando...
curl -s -X GET "%BASE_URL%/api/bullies" -H "Accept: application/json" > nul
if %errorlevel% neq 0 (
    echo ERROR: No se puede conectar a la API en %BASE_URL%
    echo Asegurate de que el servidor este corriendo en el puerto 8080
    pause
    exit /b 1
)
echo ✅ API conectada exitosamente!
echo.

echo ========================================
echo  CREANDO CLIQUES...
echo ========================================

echo Creando: Los Wannabe Influencers...
curl -s -X POST "%BASE_URL%/api/cliques" -H "Content-Type: application/json" -d "{\"name\":\"Los Wannabe Influencers\",\"description\":\"Grupo que se creia famoso por tener 200 seguidores y hacer TikToks cringe\"}" > nul
echo ✅ Los Wannabe Influencers creado

echo Creando: Banda de la Cafeteria...
curl -s -X POST "%BASE_URL%/api/cliques" -H "Content-Type: application/json" -d "{\"name\":\"Banda de la Cafeteria\",\"description\":\"Los que controlaban las mesas de la cafeteria y decidian el orden social del almuerzo\"}" > nul
echo ✅ Banda de la Cafeteria creado

echo Creando: Los Pseudo Intelectuales...
curl -s -X POST "%BASE_URL%/api/cliques" -H "Content-Type: application/json" -d "{\"name\":\"Los Pseudo Intelectuales\",\"description\":\"Se creian superiores por leer un libro al ano y usar palabras fancy\"}" > nul
echo ✅ Los Pseudo Intelectuales creado

echo Creando: Los Nicks...
curl -s -X POST "%BASE_URL%/api/cliques" -H "Content-Type: application/json" -d "{\"name\":\"Los Nicks\",\"description\":\"Grupo de gente que se creen Tony Stark\"}" > nul
echo ✅ Los Nicks creado

echo Creando: Los Caballeros...
curl -s -X POST "%BASE_URL%/api/cliques" -H "Content-Type: application/json" -d "{\"name\":\"Los Caballeros\",\"description\":\"Grupo selecto que se creen los mas educados y correctos de la Universidad\"}" > nul
echo ✅ Los Caballeros creado

echo Creando: Los NPCs...
curl -s -X POST "%BASE_URL%/api/cliques" -H "Content-Type: application/json" -d "{\"name\":\"Los NPCs\",\"description\":\"Grupo de personas que siguen las reglas al pie de la letra y no se atreven a salir de su zona de confort\"}" > nul
echo ✅ Los NPCs creado

echo.
echo ========================================
echo  CREANDO BULLIES EPICOS...
echo ========================================

echo Creando: Sebastian Vargas (Sebas Viral)...
curl -s -X POST "%BASE_URL%/api/bullies" -H "Content-Type: application/json" -d "{\"name\":\"Sebastian Vargas\",\"nickname\":\"Sebas Viral\",\"highSchoolRole\":\"OTHER\",\"cliqueId\":5,\"bullyingReason\":\"Se burlaba de mis dibujos diciendo que eran 'contenido para perdedores' mientras el hacia TikToks bailando mal\",\"levelOfAnnoyance\":9}" > nul
echo ✅ Sebastian Vargas creado

echo Creando: Isabella Santos (Isa Queen)...
curl -s -X POST "%BASE_URL%/api/bullies" -H "Content-Type: application/json" -d "{\"name\":\"Isabella Santos\",\"nickname\":\"Isa Queen\",\"highSchoolRole\":\"GOSSIP\",\"cliqueId\":6,\"bullyingReason\":\"Me prohibia sentarme en 'su' mesa y organizaba el bullying sistematico durante el almuerzo\",\"levelOfAnnoyance\":10}" > nul
echo ✅ Isabella Santos creado

echo Creando: Andres Moreno (El Intelectual)...
curl -s -X POST "%BASE_URL%/api/bullies" -H "Content-Type: application/json" -d "{\"name\":\"Andres Moreno\",\"nickname\":\"El Intelectual\",\"highSchoolRole\":\"NERD_HATER\",\"cliqueId\":6,\"bullyingReason\":\"Decia que el anime era 'cultura inferior' y que mis gustos eran 'basicos y sin profundidad intelectual'\",\"levelOfAnnoyance\":7}" > nul
echo ✅ Andres Moreno creado

echo Creando: Camila Torres (Cami Fit)...
curl -s -X POST "%BASE_URL%/api/bullies" -H "Content-Type: application/json" -d "{\"name\":\"Camila Torres\",\"nickname\":\"Cami Fit\",\"highSchoolRole\":\"JOCK\",\"cliqueId\":2,\"bullyingReason\":\"Se burlaba de mi fisico en educacion fisica y me decia 'otaku gorda' frente a todos\",\"levelOfAnnoyance\":8}" > nul
echo ✅ Camila Torres creado

echo Creando: Ricardo Mendoza (Ricky Perfecto)...
curl -s -X POST "%BASE_URL%/api/bullies" -H "Content-Type: application/json" -d "{\"name\":\"Ricardo Mendoza\",\"nickname\":\"Ricky Perfecto\",\"highSchoolRole\":\"TEACHER_PET\",\"cliqueId\":4,\"bullyingReason\":\"Me acusaba falsamente con los profesores y se inventaba que yo copiaba sus tareas perfectas\",\"levelOfAnnoyance\":6}" > nul
echo ✅ Ricardo Mendoza creado

echo Creando: Kevin Lopez (Tryhard99)...
curl -s -X POST "%BASE_URL%/api/bullies" -H "Content-Type: application/json" -d "{\"name\":\"Kevin Lopez\",\"nickname\":\"Tryhard99\",\"highSchoolRole\":\"JOCK\",\"cliqueId\":1,\"bullyingReason\":\"Decia que yo era un 'NPC sin logros' porque no jugaba LOL ni sabia de builds de Dota\",\"levelOfAnnoyance\":7}" > nul
echo ✅ Kevin Lopez creado

echo Creando: Daniela Ramirez (La Dani)...
curl -s -X POST "%BASE_URL%/api/bullies" -H "Content-Type: application/json" -d "{\"name\":\"Daniela Ramirez\",\"nickname\":\"La Dani\",\"highSchoolRole\":\"GOSSIP\",\"cliqueId\":6,\"bullyingReason\":\"Subia videos burlandose de mi forma de vestir y se hacian virales en el colegio\",\"levelOfAnnoyance\":9}" > nul
echo ✅ Daniela Ramirez creado

echo Creando: Santiago Perez (Santi Cool)...
curl -s -X POST "%BASE_URL%/api/bullies" -H "Content-Type: application/json" -d "{\"name\":\"Santiago Perez\",\"nickname\":\"Santi Cool\",\"highSchoolRole\":\"JOCK\",\"cliqueId\":5,\"bullyingReason\":\"Se volvio 'cool' y empezo a hacerme bullying para encajar con su nuevo grupo\",\"levelOfAnnoyance\":10}" > nul
echo ✅ Santiago Perez creado

echo Creando: Valentina Rojas (Vale Ironia)...
curl -s -X POST "%BASE_URL%/api/bullies" -H "Content-Type: application/json" -d "{\"name\":\"Valentina Rojas\",\"nickname\":\"Vale Ironia\",\"highSchoolRole\":\"TEACHER_PET\",\"cliqueId\":4,\"bullyingReason\":\"Me lanzaba indirectas pesadas cada vez que respondia mal en clase y todos se reian\",\"levelOfAnnoyance\":6}" > nul
echo ✅ Valentina Rojas creado

echo Creando: Andres Castano (Vegandres)...
curl -s -X POST "%BASE_URL%/api/bullies" -H "Content-Type: application/json" -d "{\"name\":\"Andres Castano\",\"nickname\":\"Vegandres\",\"highSchoolRole\":\"TEACHER_PET\",\"cliqueId\":3,\"bullyingReason\":\"Me decia asesina porque comia salchipapas en los descansos y me dejaba carteles en la lonchera\",\"levelOfAnnoyance\":8}" > nul
echo ✅ Andres Castano creado

echo Creando: Maria Jose Rivera (Majo Dance)...
curl -s -X POST "%BASE_URL%/api/bullies" -H "Content-Type: application/json" -d "{\"name\":\"Maria Jose Rivera\",\"nickname\":\"Majo Dance\",\"highSchoolRole\":\"JOCK\",\"cliqueId\":2,\"bullyingReason\":\"Me hacia sentir invisible en las coreografias y le decia a todos que se movia mas un alkaseltzer en una mazamorra que yo bailando\",\"levelOfAnnoyance\":9}" > nul
echo ✅ Maria Jose Rivera creado

echo.
echo ========================================
echo  CREANDO REVENGE PLANS EPICOS...
echo ========================================

echo Creando plan: De Viral a Invisible...
curl -s -X POST "%BASE_URL%/api/revenge-plans" -H "Content-Type: application/json" -d "{\"title\":\"De Viral a Invisible: La Saga de Sebas\",\"description\":\"Sebastian ahora tiene 47 seguidores y vende productos de limpieza por catalogo. Su ultimo TikTok tiene 3 views (todas mias para reirme). Plan incluye compilacion de sus videos cringe vs su realidad actual.\",\"bullyId\":1,\"datePlanned\":\"2024-12-01\"}" > nul
echo ✅ Plan de Sebastian creado

echo Creando plan: De Queen a Karen...
curl -s -X POST "%BASE_URL%/api/revenge-plans" -H "Content-Type: application/json" -d "{\"title\":\"Isabella: De Queen a Karen Desempleada\",\"description\":\"La ex-reina de la cafeteria ahora hace drama en grupos de Facebook de madres y trabaja en un call center. The throne has fallen and she's taking complaints about cable service.\",\"bullyId\":2,\"datePlanned\":\"2024-11-25\"}" > nul
echo ✅ Plan de Isabella creado

echo Creando plan: El Filosofo de Walmart...
curl -s -X POST "%BASE_URL%/api/revenge-plans" -H "Content-Type: application/json" -d "{\"title\":\"Andres: De Intelectual a Empleado del Mes\",\"description\":\"El pseudo-intelectual termino empacando en Walmart. Ironicamente, ahora yo soy la que tiene carrera exitosa mientras el pregunta 'bolsa o sin bolsa?'. Time for some philosophical revenge.\",\"bullyId\":3,\"datePlanned\":\"2024-12-10\"}" > nul
echo ✅ Plan de Andres creado

echo Creando plan: Fitness Reality Check...
curl -s -X POST "%BASE_URL%/api/revenge-plans" -H "Content-Type: application/json" -d "{\"title\":\"Camila's Fitness Reality Check\",\"description\":\"Cami the 'fit queen' ahora vende batidos detox en Instagram con 0 engagement. Meanwhile, I'm out here being a successful entrepreneur. The glow up comparison is ICONIC.\",\"bullyId\":4,\"datePlanned\":\"2024-12-20\"}" > nul
echo ✅ Plan de Camila creado

echo Creando plan: Del Teacher's Pet al Unemployed...
curl -s -X POST "%BASE_URL%/api/revenge-plans" -H "Content-Type: application/json" -d "{\"title\":\"Ricardo: Del Teacher's Pet al Unemployed Disaster\",\"description\":\"Ricky 'el perfecto' ha cambiado de trabajo 8 veces en 2 anos. Sus referencias perfectas no lo salvaron de ser un disaster employee. Time to document this beautiful karma.\",\"bullyId\":5,\"datePlanned\":\"2025-01-05\"}" > nul
echo ✅ Plan de Ricardo creado

echo.
echo ========================================
echo  SUBIENDO MEDIA EPICO...
echo ========================================

echo Subiendo meme de Sebastian...
curl -s -X POST "%BASE_URL%/api/media" -H "Content-Type: application/json" -d "{\"revengePlanId\":2,\"type\":\"MEME\",\"url\":\"https://imgur.com/sebas-influencer-fail\",\"caption\":\"POV: You peaked at 200 TikTok followers and now you're selling Tupperware to your 3 remaining followers\"}" > nul
echo ✅ Meme de Sebastian subido

echo Subiendo video de Isabella...
curl -s -X POST "%BASE_URL%/api/media" -H "Content-Type: application/json" -d "{\"revengePlanId\":1,\"type\":\"VIDEO\",\"url\":\"https://tiktok.com/line/isabella-karen-transformation\",\"caption\":\"From cafeteria queen to 'Can I speak to your manager?' - The pipeline is REAL\"}" > nul
echo ✅ Video de Isabella subido

echo Subiendo foto de Sebastian...
curl -s -X POST "%BASE_URL%/api/media" -H "Content-Type: application/json" -d "{\"revengePlanId\":1,\"type\":\"PHOTO\",\"url\":\"https://instagram.com/line/sebas-reality-check\",\"caption\":\"Then: 'I'm gonna be the next MrBeast' | Now: 'Have you considered our premium cleaning products?' The character development!\"}" > nul
echo ✅ Foto de Sebastian subida

echo Subiendo drawing de Andres...
curl -s -X POST "%BASE_URL%/api/media" -H "Content-Type: application/json" -d "{\"revengePlanId\":3,\"type\":\"DRAWING\",\"url\":\"https://deviantart.com/line/andres-walmart-philosopher\",\"caption\":\"Fan art of Andres contemplating the existential crisis of 'paper or plastic?' - Truly deep philosophical work\"}" > nul
echo ✅ Drawing de Andres subido

echo Subiendo meme de Camila...
curl -s -X POST "%BASE_URL%/api/media" -H "Content-Type: application/json" -d "{\"revengePlanId\":4,\"type\":\"MEME\",\"url\":\"https://imgur.com/camila-fitness-fake\",\"caption\":\"Her: 'You'll never be fit' | Also her: Selling fake detox shakes with 0 likes. The irony is IMMACULATE\"}" > nul
echo ✅ Meme de Camila subido

echo Subiendo video de Ricardo...
curl -s -X POST "%BASE_URL%/api/media" -H "Content-Type: application/json" -d "{\"revengePlanId\":5,\"type\":\"VIDEO\",\"url\":\"https://tiktok.com/line/ricardo-job-hopping\",\"caption\":\"8 jobs in 2 years compilation! From 'perfect student' to 'sir, this is a Wendy's' - The ultimate plot twist\"}" > nul
echo ✅ Video de Ricardo subido

echo Subiendo drawing extra de Isabella...
curl -s -X POST "%BASE_URL%/api/media" -H "Content-Type: application/json" -d "{\"revengePlanId\":2,\"type\":\"DRAWING\",\"url\":\"https://deviantart.com/line/isabella-karen-evolution\",\"caption\":\"Evolution chart: High school queen -> Facebook Karen -> Call center employee. Natural selection at work!\"}" > nul
echo ✅ Drawing extra de Isabella subido

echo Subiendo meme filosofico de Andres...
curl -s -X POST "%BASE_URL%/api/media" -H "Content-Type: application/json" -d "{\"revengePlanId\":3,\"type\":\"MEME\",\"url\":\"https://imgur.com/andres-philosophy-walmart\",\"caption\":\"'The unexamined life is not worth living' - Socrates | 'Paper or plastic?' - Andres 2024. The intellectual journey!\"}" > nul
echo ✅ Meme filosofico de Andres subido

echo Subiendo foto de Camila fitness fail...
curl -s -X POST "%BASE_URL%/api/media" -H "Content-Type: application/json" -d "{\"revengePlanId\":4,\"type\":\"PHOTO\",\"url\":\"https://instagram.com/line/camila-detox-fail\",\"caption\":\"Selling detox shakes while looking like she needs to detox from her own drama. The business model is questionable at best\"}" > nul
echo ✅ Foto de Camila subida

echo.
echo ========================================
echo  DOCUMENTANDO MOOD TRACKER...
echo ========================================

echo Registrando dia de victoria Sebastian...
curl -s -X POST "%BASE_URL%/api/mood-tracker" -H "Content-Type: application/json" -d "{\"date\":\"2024-12-01\",\"moodLevel\":10,\"note\":\"EL PLAN DE SEBASTIAN FUE EPICO! Su video de mi venganza tiene 500K views y el solo tiene 47 seguidores. The SATISFACTION is unmatched! I'm literally glowing\"}" > nul
echo ✅ Mood de victoria Sebastian registrado

echo Registrando research day Isabella...
curl -s -X POST "%BASE_URL%/api/mood-tracker" -H "Content-Type: application/json" -d "{\"date\":\"2024-11-25\",\"moodLevel\":9,\"note\":\"Found Isabella's LinkedIn where she lists 'Customer Experience Specialist' (aka call center). Meanwhile I'm here being a successful entrepreneur. The tables have TURNED!\"}" > nul
echo ✅ Mood de research Isabella registrado

echo Registrando investigacion Andres...
curl -s -X POST "%BASE_URL%/api/mood-tracker" -H "Content-Type: application/json" -d "{\"date\":\"2024-11-20\",\"moodLevel\":8,\"note\":\"Spotted Andres at Walmart in his uniform. The 'intellectual superior' is now asking if I want my receipt. The philosophical irony is CHEF'S KISS!\"}" > nul
echo ✅ Mood de investigacion Andres registrado

echo Registrando reality check Camila...
curl -s -X POST "%BASE_URL%/api/mood-tracker" -H "Content-Type: application/json" -d "{\"date\":\"2024-11-18\",\"moodLevel\":7,\"note\":\"Camila's 'fitness empire' Instagram has 200 followers and her last post got 3 likes. The girl who called me 'otaku gorda' can't even sell her fake shakes. Justice is SWEET\"}" > nul
echo ✅ Mood de reality check Camila registrado

echo Registrando karma Ricardo...
curl -s -X POST "%BASE_URL%/api/mood-tracker" -H "Content-Type: application/json" -d "{\"date\":\"2024-11-15\",\"moodLevel\":9,\"note\":\"LinkedIn says Ricardo changed jobs AGAIN (job #9 this year). The 'perfect student' can't keep a job for more than 2 months. My career is thriving while his is... not. Karma at its finest!\"}" > nul
echo ✅ Mood de karma Ricardo registrado

echo Registrando reflexion general...
curl -s -X POST "%BASE_URL%/api/mood-tracker" -H "Content-Type: application/json" -d "{\"date\":\"2024-11-22\",\"moodLevel\":10,\"note\":\"Looking back at all my bullies and their current situations... I've literally become everything they said I couldn't be. Model, entrepreneur, content creator, and most importantly - HAPPY. The glow up is COMPLETE!\"}" > nul
echo ✅ Reflexion general registrada

echo.
echo ========================================
echo  🎉 POBLADO COMPLETO! 🎉
echo ========================================
echo.
echo ✅ Line's Revenge Empire esta completo y operacional!
echo 👑 Justice served at 60fps with motion blur! ✨
echo.
echo Database poblada exitosamente con:
echo - 6 Cliques epicos
echo - 11 Bullies documentados
echo - 5 Revenge Plans estrategicos
echo - 9 Media files subidos
echo - 6 Mood tracker entries
echo.
echo La venganza esta servida! 💅✨
echo.
pause