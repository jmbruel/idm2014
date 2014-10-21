all: figs modelisad.pdf

modelisad.pdf: modelisad.tex
	pdflatex modelisad.tex
#	pdflatex modelisad.tex

figs: figures
	make -C figures pdf

clean: cleantex

cleantex:
	rm -f *.aux *.log *.toc *.pdf *.bbl *.blg *.dvi *.ps *~ *.bak *.bmt \
		*.out *.lof *.lot *.mlf? *.mlt? *.mtc *.mtc? \
		*.idx *.ilg *.ind \
		*.nav *.snm *.vrb
